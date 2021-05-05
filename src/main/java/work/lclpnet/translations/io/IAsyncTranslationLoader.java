/*
 * Copyright (c) 2021 LCLP.
 *
 * Licensed under the MIT License. For more information, consider the LICENSE file in the project's root directory.
 */

package work.lclpnet.translations.io;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Used to load translations from somewhere.
 */
public interface IAsyncTranslationLoader {

    /**
     * Load translations from somewhere.
     * The returned {@link Map}'s keys are languages loaded, while the values are key-value translation pairs.
     *
     * @return A completable future that will receive the map containing the translations.
     * @throws IOException If there was an I/O-error loading the translations.
     */
    CompletableFuture<Map<String, Map<String, String>>> load() throws IOException;

}
