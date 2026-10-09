class classprb3 {
    static final class NameTag {
        private final String firstName;
        private final String lastName;
        NameTag(String fullName) {
            if (fullName == null) throw new IllegalArgumentException("Name cannot be null");
            String[] parts = fullName.trim().split("\\s+", 2);
            if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty())
                throw new IllegalArgumentException("Enter a first and last name");
            firstName = parts[0]; lastName = parts[1];
        }
        String getNickname() { return firstName + " " + lastName.charAt(0) + "."; }
    }
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
