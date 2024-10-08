/*
 * Copyright (c) 2024 LCLP.
 *
 * Licensed under the MIT License. For more information, consider the LICENSE file in the project's root directory.
 */

package work.lclpnet.translations.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import work.lclpnet.translations.loader.TranslationLoader;
import work.lclpnet.translations.loader.TranslationProvider;
import work.lclpnet.translations.network.LCLPNetworkTranslationLoader;

import java.util.Collections;

public class LCLPNetworkTranslationProvider implements TranslationProvider {

    private final Logger logger = LoggerFactory.getLogger(LCLPNetworkTranslationProvider.class);

    @Override
    public TranslationLoader create() {
        // could also use org.slf4j.helpers.NOPLogger.NOP_LOGGER if log is unwanted
        return new LCLPNetworkTranslationLoader(Collections.singletonList("mc_server"), null, logger);
    }
}
