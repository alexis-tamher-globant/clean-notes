//
//  NoteListViewModel.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 10/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension NoteListScreen {
    
    @MainActor class NoteListViewModel: ObservableObject {
        
        private let dataSource = NoteDataSourceImpl()
        private let noteFilter = NoteFilter()
        private var allNotes = [Note]()
        @Published private(set) var notes = [Note]()
        @Published private(set) var isSearching = false
        @Published var query = "" {
            didSet {
                self.notes = noteFilter.filter(notes: self.allNotes, query: query)
            }
        }
        
        func loadNotes() {
            dataSource.getAllNotes { notes, error in
                self.allNotes = notes ?? []
                self.notes = self.allNotes
            }
        }
        
        func onSearch(query: String) {
            self.query = query
        }
        
        func toggleIsSearching() {
            isSearching = !isSearching
        }
        
        func deleteNote(id: Int64) {
            dataSource.deleteNoteById(id: id) { _ in
                self.loadNotes()
            }
        }
        
    }
    
}
