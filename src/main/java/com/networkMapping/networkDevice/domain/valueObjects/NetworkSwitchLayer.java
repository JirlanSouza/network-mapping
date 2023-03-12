package com.networkMapping.networkDevice.domain.valueObjects;

public enum NetworkSwitchLayer {
    LAYER1 {
        @Override
        public boolean acceptableConnection(NetworkSwitchLayer layer) {
            return true;
        }
    },
    LAYER2 {
        @Override
        public boolean acceptableConnection(NetworkSwitchLayer layer) {
            return layer == NetworkSwitchLayer.LAYER2 || layer == NetworkSwitchLayer.LAYER3;
        }
    },
    LAYER3 {
        @Override
        public boolean acceptableConnection(NetworkSwitchLayer layer) {
            return layer == NetworkSwitchLayer.LAYER2;
        }
    };

    public abstract boolean acceptableConnection(NetworkSwitchLayer layer);
}
