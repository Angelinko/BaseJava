package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                storage[i] = r;
            }
            else {
                System.out.println("Resume not find");
            }

        }
    }

    public void save(Resume r) {
        for (int i = 0; i < count; i++) {
           if (storage[i].uuid.equals(r.uuid)) {
               System.out.println("Resume exist");
           }
           else {
               storage[i] = r;
               count++;
               break;
           }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count -1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
            else {
                System.out.println("Resume not find");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count -1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < count; j++) {
                    storage[j] = storage[j + 1];
                }
                count--;
                break;
            }
            else {
                System.out.println("Resume not find");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}