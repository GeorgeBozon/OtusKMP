import SwiftUI
import shared

@main
struct iOSApp: App {
    init(){
        KoinInitIOSKt.doInitKoinIos()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
