//
//  NoteItem.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 08/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import Foundation
import shared

struct NoteItem: View {
    var note: Note
    var onDeleteTapped: () -> Void = {}
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack{
                Text(note.title)
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Button(action: { onDeleteTapped() }) {
                    Image(systemName: "xmark")
                        .foregroundColor(.black)
                }
            }
            Text(note.content)
                .fontWeight(.light)
            Text(DateTimeUtil().formatNoteDate(dateTime: note.date))
                .font(.caption)
                .fontWeight(.light)
                .frame(maxWidth: .infinity, alignment: .trailing)
        }
        .padding()
        .background(Color(hex: Int64(note.color)))
        .clipShape(RoundedRectangle(cornerRadius: 5))
    }
}


struct NoteItem_Previews: PreviewProvider {
    static var previews: some View {
        //NoteItem()
        EmptyView()
    }
}


