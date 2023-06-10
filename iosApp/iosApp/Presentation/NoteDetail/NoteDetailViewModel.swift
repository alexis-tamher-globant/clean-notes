//
//  NoteDetailViewModel.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 10/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension NoteDetailScreen {
    @MainActor class NoteDetailViewModel: ObservableObject {
        
        private let dataSource = shared.NoteDataSourceImpl()
        
        private var currentId: Int64 = -1
        @Published var title: String = ""
        @Published var content: String = ""
        @Published private(set) var color: Int64 = ColorsKt.randomColor()
        
        func loadNote(noteId: Int64) {
            dataSource.getNoteById(id: noteId) { note, error in
                if note != nil {
                    self.currentId = note!.id
                    self.title = note!.title
                    self.content = note!.content
                    self.color = note!.color
                }
            }
        }
        
        func saveNote() {
            let note = Note(id: currentId, title: title, content: content, color: color, date: DateTimeUtil().now())
            dataSource.insertNote(note: note) { _ in }
        }
        
    }
}
