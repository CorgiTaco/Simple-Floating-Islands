package corgitaco.simplefloatingislands.platform;

import corgitaco.simplefloatingislands.Constants;
import corgitaco.simplefloatingislands.platform.services.ModPlatform;

import java.util.ServiceLoader;

public class Services {

    public static final ModPlatform PLATFORM = load(ModPlatform.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
