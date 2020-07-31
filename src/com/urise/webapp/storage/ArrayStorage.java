package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[3];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume resume) {
        int index = findResume(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Resume update " + resume.getUuid());
        } else {
            System.out.println("Resume not find " + resume.getUuid());
        }
    }

    public void save(Resume resume) {
        if (findResume(resume.getUuid()) != -1) {
            System.out.println("Resume exist " + resume.getUuid());
        } else {
            storage[count] = resume;
            count++;
            System.out.println("Resume saved " + resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = findResume(uuid);
        if (index != -1) {
            System.out.println("Resume find " + uuid);
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = findResume(uuid);
        if (index != -1) {
            count--;
            storage[index] = storage[count];
            storage[count] = null;
            System.out.println("Resume deleted " + uuid);
        } else {
            System.out.println("Resume not find " + uuid);
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

    private int findResume(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}