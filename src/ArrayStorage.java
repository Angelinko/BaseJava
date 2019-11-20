import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
       return resume;

    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < storage.length - 1; j++) {
                    storage[j] = storage[j + 1];
                    if (storage[j] == null) {
                        storage[j - 1] = null;
                        break;
                    }
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int newLength = 0;
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                newLength ++;
            }
        }
        return Arrays.copyOf(storage, newLength);
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                size = i + 1;
            }
        }
        return size;
    }
}
