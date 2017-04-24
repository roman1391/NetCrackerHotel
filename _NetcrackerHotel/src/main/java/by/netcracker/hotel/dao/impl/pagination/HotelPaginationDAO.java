package by.netcracker.hotel.dao.impl.pagination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.netcracker.hotel.dao.HotelDAO;
import by.netcracker.hotel.entities.Hotel;
import by.netcracker.hotel.entities.pagination.HotelSearchParam;

@Repository
public class HotelPaginationDAO implements com.github.paginationspring.dao.PaginationDao<Hotel, HotelSearchParam> {

    HotelDAO hotelDAO;

    @Autowired
    public HotelPaginationDAO(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    @Override
    public int retrieveCountResult(HotelSearchParam pparam) throws Exception {
        HotelSearchParam param = (HotelSearchParam) pparam;
        List<Hotel> list = hotelDAO.getAll();
        list = filterList(list, param);
        return list.size();
    }

    @Override
    public List<Hotel> retrievePageResult(HotelSearchParam pparam) throws Exception {
        List<Hotel> list = hotelDAO.getAll();
        int index = Integer.parseInt(pparam.getResultIndex());
        HotelSearchParam param = (HotelSearchParam) pparam;

        sortList(list, param);
        list = filterList(list, param);
        List<Hotel> list1 = getOnePage(list, index);
        return list1;
    }

    private List<Hotel> getOnePage(List<Hotel> list, int index) {
        List<Hotel> list1 = new ArrayList<Hotel>();
        for (int i = index; i < index + 10; i++) {
            if (list.size() > i) {
                list1.add(list.get(i));
            }
        }
        return list1;
    }

    private List<Hotel> filterList(List<Hotel> list, HotelSearchParam param) {
        if (param.getCity() != null && !param.getCity().equals("")) {
            List<Hotel> list1 = new ArrayList<Hotel>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCity().equals(param.getCity())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if (param.getName() != null && !param.getName().equals("")) {
            List<Hotel> list1 = new ArrayList<Hotel>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().contains((param.getName()))) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        if ((param.getTypeOfService() != null) && !param.getTypeOfService().equals("")) {
            List<Hotel> list1 = new ArrayList<Hotel>();
            for (int i = 0; i < list.size(); i++) {
                if (String.valueOf(list.get(i).getTypeOfService()).equals(param.getTypeOfService())) {
                    list1.add(list.get(i));
                }
            }
            list = list1;
        }
        return list;
    }

    private void sortList(List<Hotel> list, HotelSearchParam param) {
        if (param.getSortName() != null && !param.getSortName().equals("")) {
            System.out.println(param.getSortName());
            if (param.getSortName().equals("Name")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel1.getName().compareTo(hotel2.getName());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a")) {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel2.getName().compareTo(hotel1.getName());
                        }
                    });
                }
            } else if (param.getSortName().equals("City")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel1.getCity().compareTo(hotel2.getCity());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a"))

                {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel2.getCity().compareTo(hotel1.getCity());
                        }
                    });
                }
            } else if (param.getSortName().equals("Country")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel1.getCountry().compareTo(hotel2.getCountry());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a"))

                {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel2.getCountry().compareTo(hotel1.getCountry());
                        }
                    });
                }
            } else if (param.getSortName().equals("Service")) {
                if (param.getSortAscDesc().equals("d")) {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel1.getTypeOfService() - (hotel2.getTypeOfService());
                        }
                    });
                } else if (param.getSortAscDesc().equals("a"))

                {
                    Collections.sort(list, new Comparator<Hotel>() {
                        @Override
                        public int compare(Hotel hotel1, Hotel hotel2) {
                            return hotel2.getTypeOfService() - (hotel1.getTypeOfService());
                        }
                    });
                }
            }
        }
    }

}
