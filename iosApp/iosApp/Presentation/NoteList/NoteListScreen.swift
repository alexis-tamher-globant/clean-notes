//
//  NoteListScreen.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 09/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteListScreen: View {
    
    @StateObject var viewModel = NoteListViewModel()
    @State private var isActive: Bool = false
    @State private var noteId: Int64? = nil
    
    var body: some View {
        VStack {
            NavigationLink(destination: NoteDetailScreen(noteId: noteId), isActive: $isActive) { EmptyView() }.hidden()
            HStack {
                if(!viewModel.isSearching){
                    Text("All notes")
                        .font(.title)
                        .bold()
                        .frame(maxWidth: .infinity, alignment: .center)
                        .padding(8)
                }
                SearchBar(
                    text: $viewModel.query,
                    isSearching: viewModel.isSearching,
                    onSearchTapped: {
                        viewModel.toggleIsSearching()
                    },
                    onCloseTapped: {
                        viewModel.toggleIsSearching()
                    },
                    onAddTapped: {
                        isActive.toggle()
                    }
                )
            }
            if viewModel.notes.isEmpty {
                Text("There are no notes yet\nAdd some note... :D")
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
            }
            List {
                ForEach(viewModel.notes, id: \.self.id) { note in
                    Button(action: {
                        noteId = note.id?.int64Value
                        isActive.toggle()
                    }) {
                        NoteItem(
                            note: note,
                            onDeleteTapped: {
                                viewModel.deleteNote(id: note.id!.int64Value)
                            }
                        )
                    }
                    .padding(8)
                    .listRowInsets(EdgeInsets())
                }
            }
            .onAppear {
                viewModel.loadNotes()
                noteId = nil
            }
            .listStyle(.plain)
        }
        
    }
}

struct NoteListScreen_Previews: PreviewProvider {
    static var previews: some View {
        NoteListScreen()
    }
}
