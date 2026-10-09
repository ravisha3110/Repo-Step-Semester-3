class classprb5 {
    static class AttendanceSheet {
        private final String[] presentStudents;
        private int presentCount;

        AttendanceSheet(int capacity) {
            if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
            presentStudents = new String[capacity];
        }

        boolean markPresent(String name) {
            if (name == null || name.trim().isEmpty() || isPresent(name)) return false;
            if (presentCount == presentStudents.length) return false;
            presentStudents[presentCount++] = name;
            return true;
        }

        int getPresentCount() { return presentCount; }

        boolean isPresent(String name) {
            for (int i = 0; i < presentCount; i++)
                if (presentStudents[i].equals(name)) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("Present: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
    }
}
