package app.androld.bundlekt;

final class Enums {
    private Enums() {
    }

    static <T extends Enum<T>> T createEnumInstance(String name, Class<T> type) {
        return Enum.valueOf(type, name);
    }
}
