import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel = StopwatchViewModelWrapper()
    
    var body: some View {
        VStack {
            Text(viewModel.uiState.formattedTime)
                .padding()
            
            HStack(spacing: 8) {
                Button(action: viewModel.onStartClicked, label: {
                    Text("Start")
                })
                Button(action: viewModel.onStopClicked, label: {
                    Text("Stop")
                })
            }
            Button(action: {viewModel.onCopyToClipboardClicked(text: viewModel.uiState.formattedTime)}, label: {Text("Copy to clipboard")} )
            Text("Text from buffer: \(viewModel.uiState.clipboardText)")
        }
    }
}

class StopwatchViewModelWrapper: ObservableObject {
    private lazy var viewModel =   KoinIosDependencies().getViewModel()
    private var observer: Cancellable?
    
    @Published var uiState: StopwatchUiState = StopwatchUiState(currentTimeMillis: 0, initialTimeMillis: 0, clipboardText: "buffer is empty")
    
    func onStartClicked() {
        viewModel.onStartClicked()
    }
    
    func onStopClicked() {
        viewModel.onStopClicked()
    }
    
    func onCopyToClipboardClicked(text: String){
        viewModel.onCopyToClipBoard(text: text)
    }
    
    init() {
    observer = viewModel.uiState.collect {
            [weak self] value in self?.uiState = value
        }
    }
    
    deinit {
       observer?.cancel()
       viewModel.onDestroy()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
