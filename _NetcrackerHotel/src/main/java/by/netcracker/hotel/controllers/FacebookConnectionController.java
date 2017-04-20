package by.netcracker.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;

/**
 * Created by slava on 20.04.17.
 */
@Controller
public class FacebookConnectionController extends ConnectController {

    @Autowired
    public FacebookConnectionController(ConnectionFactoryLocator connectionFactoryLocator,
                                        ConnectionRepository connectionRepository){
        super(connectionFactoryLocator,connectionRepository);
    }

    @Override
    protected String connectedView(String providerId) {
        return super.connectedView(providerId);
    }

}
