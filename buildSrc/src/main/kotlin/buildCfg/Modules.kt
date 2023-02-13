object Modules {
    const val app = ":app"
    const val buildSrc = ":buildSrc"

    object Features {
        const val entryList = ":features:entry-list"
    }

    object Lib {
        object Generic {
            const val error = ":lib-generic:error"
            const val network = ":lib-generic:network"
            const val ui = ":lib-generic:ui"
        }
        object Specific {
            const val localDb = ":lib-specific:local-db"
            const val uiTheme = ":lib-specific:ui-theme"
        }
    }
}