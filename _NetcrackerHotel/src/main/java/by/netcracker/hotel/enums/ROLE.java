package by.netcracker.hotel.enums;

/**
 * Created by Alexander on 10.04.2017.
 */
public enum ROLE {
    ADMIN(0), USER(1), GUEST(2), BLOCKED(3);

    private int role;

    ROLE(int i) {
        role = i;
    }

    public int getRole() {
        return role;
    }

    public static ROLE get(int id) {
        for (ROLE role : ROLE.values()) {
            if(role.getRole() == id){
                return role;
            }
        }
        return null;
    }
}
