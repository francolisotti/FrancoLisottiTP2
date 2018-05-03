package com.utn.francolisotti.TP4.controller;

import com.utn.francolisotti.TP4.model.User;
import com.utn.francolisotti.TP4.repository.JPARepositoryImplementation;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    JPARepositoryImplementation jpaRepositoryImplementation;
    User user;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public User loadUser(@RequestHeader("User-Agent") String request ) {
        //Se obtiene UserAgent
        UserAgent userAgent = UserAgent.parseUserAgentString(request);
        //Se obtiene un solo el browser y el os
        String browserAndOs = userAgent.toString();
        // Se lo convierte a String
        String[] separacion;
        separacion = browserAndOs.split("-");
        String os = separacion[0];
        String browser = separacion[1];
        //Se los separa en dos String para la creacion del User

        user = new User (browser,os);
        jpaRepositoryImplementation.save(user);

        return user;
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json")
    public String dataUsers() {

        List<User> listaUsers;
        listaUsers = jpaRepositoryImplementation.findAll();

        int cantChrome=0;
        int cantFirefox=0;
        int cantExplorer=0;
        int cantWindows=0;
        int cantMac=0;
        int cantLinux=0;
        String browser;
        String os;

        for (User user: listaUsers)
        {
            browser=user.getBrowser().toLowerCase();
            os=user.getOperativeS().toLowerCase();
            if (browser.contains("chrome"))
            {
                cantChrome++;
            }
            else if (browser.contains("firefox"))
            {
                cantFirefox++;
            }
            else if (browser.contains("explorer"))
            {
                cantExplorer++;
            }

            if (os.contains("windows"))
            {
                cantWindows++;
            }
            else if (os.contains("mac"))
            {
                cantMac++;
            }
            else if (os.contains("linux"))
            {
                cantLinux++;
            }
        }

        browser=this.maxBrowser(cantChrome,cantFirefox,cantExplorer);
        os=this.maxOs(cantWindows,cantMac,cantLinux);

        return "El browser mas usado es "+ browser+ " y el O.S mas usado es "+os;
    }

    @RequestMapping(value = "/combination", method = RequestMethod.GET, produces = "application/json")
    public List<?> mostUsedCombination() {

        List<?> combination;
        combination = jpaRepositoryImplementation.mostUsedCombination();
        return combination;
    }



    private String maxBrowser(int cantChrome, int cantFirefox, int cantExplorer)
    {
        String browser;
        if (cantChrome>=cantFirefox && cantChrome>=cantExplorer)
        {
            browser="Chrome";
        }
        else if (cantFirefox>cantExplorer && cantFirefox>cantChrome)
        {
            browser="Firefox";
        }
        else
        {
            browser="Explorer";
        }
        return browser;
    }

    private String maxOs(int cantWindows, int cantMac, int cantLinux)
    {
        String os;
        if (cantWindows>=cantMac && cantWindows>=cantLinux)
        {
            os="Windows";
        }
        else if (cantMac>cantWindows && cantMac>cantLinux)
        {
            os="Mac";
        }
        else
        {
            os="Linux";
        }
        return os;
    }
}
