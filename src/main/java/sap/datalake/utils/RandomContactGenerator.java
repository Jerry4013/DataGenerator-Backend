package sap.datalake.utils;

import sap.datalake.model.ContactModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/06
 **/
public class RandomContactGenerator {

    private static Random random = new Random();

    private static String[] departments = {"Human Resource", "Marketing", "Promotion", "Production", "Sales", "Customer " +
            "Service", "Accounting and Finance", "Distribution", "Research and Development", "Administrative and " +
            "Management", "Operations", "Information Technology Support", "Purchasing", "Legal Department"};

    private static int DEPARTMENT_LENGTH = departments.length;

    private static String[] titles = {"Mr", "Mrs", "Miss", "Ms", "Mx", "Sir", "Dr", "Lady"};

    private static String[] firstNames = {"Emmett", "Linnie", "Jolynn", "Marisa", "Duncan", "Georgette", "Reena", "Jacquetta",
            "Kassandra", "Ossie", "Rayna", "Many", "Shena", "Almeda", "Gwyn", "Luciano", "Elsy", "Ervin", "Thea",
            "Delia", "Victor", "Ida", "Catalina", "Nona", "Alfonzo", "Arnoldo", "Blake", "Sari"};

    private static int FIRST_LENGTH = firstNames.length;

    private static String[] lastNames = {"Wagner", "Carson", "Jefferson", "Holmes", "Bullock", "Hall", "Woodward", "Reyes",
            "Henry", "Pruitt", "Christensen", "Thompson", "Marsh", "Faulkner", "Phelps", "Haynes", "Miranda",
            "Sullivan", "Newman", "Lane", "Roach", "Matthews", "Anthony", "Floyd"};

    private static int LAST_LENGTH = lastNames.length;

    private static String[] emails = {
            "formis@hotmail.com", "crowl@me.com", "naupa@mac.com", "parrt@sbcglobal.net", "fangorn@sbcglobal.net",
            "sumdumass@gmail.com", "jyoliver@verizon.net", "adamk@gmail.com", "solomon@live.com", "netsfr@comcast.net",
            "adhere@comcast.net", "schumer@mac.com", "irving@yahoo.com", "kronvold@yahoo.ca", "fraterk@mac.com",
            "jkegl@gmail.com", "techie@msn.com", "jnolan@optonline.net", "bigmauler@live.com", "rsmartin@optonline.net",
            "szymansk@gmail.com", "ideguy@hotmail.com", "fraser@me.com", "tjensen@hotmail.com",
    };

    private static int EMAIL_LENGTH = emails.length;

    /**
     * Create a random contact. Leave account attribute as null and assemble it in the service class to avoid
     * repeated work.
     * @return A ContactModel object with a null account value
     */
    public static ContactModel generateContact() {
        String firstName = firstNames[random.nextInt(FIRST_LENGTH)];
        String lastName = lastNames[random.nextInt(LAST_LENGTH)];
        ContactModel contactModel = new ContactModel(
                lastName,
                firstName,
                firstName + " " + lastName,
                titles[random.nextInt(8)],
                emails[random.nextInt(EMAIL_LENGTH)],
                random.nextInt(2) + 1,
                random.nextInt(9),
                departments[random.nextInt(DEPARTMENT_LENGTH)],
                new Date(ThreadLocalRandom.current().nextLong(946702800000L)),
                null);
        return contactModel;
    }

    public static List<ContactModel> generateContacts(int number) {
        if (number < 1) {
            return null;
        } else if (number > 9999) {
            return null;
        }
        List<ContactModel> contactModels = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            contactModels.add(generateContact());
        }
        return contactModels;
    }
}
