package functional_interface;

import java.util.List;
import java.util.function.Function;

public class StreamDemo {
    public static Function<Gender, List<User>> getUserWithGender = gender -> getUsers().stream().filter(user -> user.gender.equals(gender)).toList();
    public static Function<Integer, List<User>> getAgeGreaterThan = age -> getUsers().stream().filter(user -> user.getAge() >= age).toList();

    public static List<User> getUsers() {
        return List.of(
                new User("Rahul", "rj@gmail.com", "7649053700", 26, Gender.MALE),
                new User("Narendra", "nandu@gmail.com", "8948628588", 25, Gender.MALE),
                new User("Sakshi", "sakshi@gmail.com", "7987819254", 23, Gender.FEMALE),
                new User("Shreyansh", "jain@gmail.com", "8358986839", 24, Gender.MALE),
                new User("Priya", "priyasoni@gmail.com", "7748829938", 24, Gender.FEMALE),
                new User("Shaba", "sparveen@gmail.com", "9479041793", 24, Gender.FEMALE)
        );
    }

    public enum Gender {
        MALE,
        FEMALE,
        TRANS,
        PREFERED_NOT_TO_SAY
    }

    public static class User {
        private final String name;
        private final String email;
        private final String mobile;
        private final int age;

        private final Gender gender;

        public User(String name, String email, String mobile, int age, Gender gender) {
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}

