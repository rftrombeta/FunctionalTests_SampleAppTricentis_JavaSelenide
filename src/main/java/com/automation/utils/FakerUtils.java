package com.automation.utils;

import com.automation.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.automation.Constants.*;

public class FakerUtils {

    public static String randomFirstNameGenerator(Gender gender) throws FileNotFoundException {

        String fileName;

        if(gender == Gender.MALE) {

            fileName = MALE_FIRST_NAMES_FILE;
        }
        else {

            fileName = FEMALE_FIRST_NAMES_FILE;
        }

        return randomDataGenerator(fileName);
    }

    public static String randomLastNameGenerator() throws FileNotFoundException {

        return randomDataGenerator(LAST_NAMES_FILE);
    }

    public static String randomPublicPlaceGenerator() throws FileNotFoundException {

        return randomDataGenerator(PUBLIC_PLACES_FILE);
    }

    public static String randomStateGenerator() throws FileNotFoundException {

        return randomDataGenerator(STATES_FILE);
    }

    public static String randomCityGenerator() throws FileNotFoundException {

        return randomDataGenerator(CITIES_FILE);
    }

    public static String emailGenerator(String name, String lastName) {

        Random random = new Random();

        String stringNormalize = Normalizer
                .normalize(name + lastName, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase();

        return stringNormalize + random.nextInt(1000) + EMAIL_HOSTING;
    }

    private static String randomDataGenerator(String fileName) throws FileNotFoundException {

        File file = new File(ROOT_FILES_FOLDER + fileName);

        Scanner scanner = new Scanner(new FileReader(file.getAbsolutePath()));

        List<String> data = new ArrayList<>();

        String line;

        while(scanner.hasNext()) {

            line = scanner.nextLine();

            data.add(line);
        }

        Random random = new Random();

        return data.get(random.nextInt((data.size()-1) + 1));
    }
}