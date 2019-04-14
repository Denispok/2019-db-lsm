package ru.mail.polis;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.jetbrains.annotations.NotNull;

public class MyDao implements DAO {

    private final NavigableMap storage = new TreeMap<ByteBuffer, Record>();

    @NotNull
    @Override
    public Iterator<Record> iterator(@NotNull final ByteBuffer from) throws IOException {
        return storage.tailMap(from).values().iterator();
    }

    @Override
    public void upsert(@NotNull final ByteBuffer key, @NotNull final ByteBuffer value) throws IOException {
        storage.put(key, Record.of(key, value));
    }

    @Override
    public void remove(@NotNull final ByteBuffer key) throws IOException {
        storage.remove(key);
    }

    @Override
    public void close() throws IOException {
        // why I still here? just to suffer?
    }
}
