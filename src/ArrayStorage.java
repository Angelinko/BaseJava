import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        Arrays.fill(storage, null);
        count = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < count; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
        count++;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < count -1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < count -1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < count; j++) {
                    storage[j] = storage[j + 1];
                    break;
                }
            }
        }
        count --;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int newLength = 0;
        for (int i = 0; i < count - 1; i++) {
            if (storage[i] != null) {
                newLength ++;
            }
        }
        return Arrays.copyOf(storage, newLength);
    }

    int size() {
        return count;
    }
}
