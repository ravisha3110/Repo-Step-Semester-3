class assiprb2 {
    static class Playlist {
        private final String[] songs;
        private int size;

        Playlist(int capacity) {
            if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative");
            songs = new String[capacity];
        }

        boolean addSong(String title) {
            if (title == null || title.trim().isEmpty() || size == songs.length || contains(title)) return false;
            songs[size++] = title;
            return true;
        }

        int getSongCount() { return size; }

        boolean contains(String title) {
            for (int i = 0; i < size; i++) if (songs[i].equals(title)) return true;
            return false;
        }

        String listSongs() {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (i > 0) result.append(", ");
                result.append(songs[i]);
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(3);
        playlist.addSong("Blue Sky");
        playlist.addSong("Night Drive");
        playlist.addSong("Blue Sky");
        System.out.println("Songs: " + playlist.listSongs());
        System.out.println("Count: " + playlist.getSongCount());
    }
}
