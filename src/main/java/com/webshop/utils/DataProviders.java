package com.webshop.utils;

import com.webshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> registerNewUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Mila", "Müller", "mila.müller@gm.com", "Mila123"});

        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]>registerNewUserFromCsv() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));
        String line = reader.readLine();
        while(line !=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
