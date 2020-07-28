package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    public boolean condition(Resume r1, String uuid) {
        if (r1.getUuid().equals(uuid)) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < count; i++) {
            if (condition(storage[i], r.getUuid())) {
                storage[i] = r;
                System.out.println("Resume update");
            } else {
                System.out.println("Resume not find");
            }
        }
    }

    public void save(Resume r) {
        for (int i = 0; i < count; i++) {
            if (condition(storage[i], r.getUuid())) {
                System.out.println("Resume exist");
            } else {
                storage[i] = r;
                count++;
                System.out.println("Resume saved");
                break;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count - 1; i++) {
            if (condition(storage[i], uuid)) {
                System.out.println("Resume find");
                return storage[i];
            } else {
                System.out.println("Resume not find");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count - 1; i++) {
            if (condition(storage[i], uuid)) {
                for (int j = i; j < count; j++) {
                    storage[j] = storage[j + 1];
                }
                count--;
                System.out.println("Resume deleted");
                break;
            } else {
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