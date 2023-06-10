//
//  NoteDetailScreen.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 10/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI


struct NoteDetailScreen: View {
    @Environment(\.presentationMode) var presentation
    var noteId: Int64
    
    @StateObject var viewModel = NoteDetailViewModel()
    
    var body: some View {
        VStack {
            
            Button(action: {
                viewModel.saveNote()
                self.presentation.wrappedValue.dismiss()
            } ) {
                Image(systemName: "checkmark").resizable().frame(width: 20, height: 20)
            }.foregroundColor(.black).frame(maxWidth: .infinity, alignment: .trailing)
                .padding(.horizontal, 6)
            
            TextField("Title", text: $viewModel.title)
                .padding(.horizontal, 6)
            
            if #available(iOS 16.0, *) {
                TextField("Content", text: $viewModel.content, axis: .vertical)
                    .lineLimit(100)
                    .padding(.horizontal, 6)
            }
            Spacer()
        }
        .onAppear {
            if noteId != -1 {
                viewModel.loadNote(noteId: noteId)
            }
        }
        .padding()
        .background(Color(hex: Int64(viewModel.color)))
        
    }
}

struct NoteDetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        
        NoteDetailScreen(noteId: 0)
        
    }
}
