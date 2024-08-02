package com.polyglot.training.util;

import com.polyglot.training.dto.BooksDTO;
import com.polyglot.training.dto.ItemsDTO;
import com.polyglot.training.dto.UsersDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    public static List<BooksDTO> dataBuku = new ArrayList<>(
            Arrays.asList(
                    BooksDTO.builder().id(0).title("Totoro").author("Ghibli").build(),
                    BooksDTO.builder().id(1).title("Howl Moving Castle").author("Ghibli").build(),
                    BooksDTO.builder().id(2).title("Bulan").author("Tere Liye").build(),
                    BooksDTO.builder().id(3).title("Matahari").author("Tere Liye").build()
            )
    );

    public static List<ItemsDTO> dataItems = new ArrayList<>(
            Arrays.asList(
                    ItemsDTO.builder().id(1).name("sunscreen").description("perawatan").stock(100).price(150000L).build(),
                    ItemsDTO.builder().id(2).name("laptop").description("elektronik").stock(50).price(20000000L).build(),
                    ItemsDTO.builder().id(99).name("hp samsung").description("elektronik").stock(50).price(20000000L).build()
            )
    );

    public static List<UsersDTO> dataUser = new ArrayList<>(
            Arrays.asList(
                    UsersDTO.builder().id(0).name("asyraf").password("asdf").build(),
                    UsersDTO.builder().id(1).name("rani").password("asdf").build()
            )
    );

}
