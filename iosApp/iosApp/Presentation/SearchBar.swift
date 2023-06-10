//
//  SearchBar.swift
//  iosApp
//
//  Created by Christian Alexis Fabian Tamariz Hernandez on 09/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SearchBar: View {
    @Binding var text: String
    var isSearching: Bool
    var onSearchTapped: () -> Void
    var onCloseTapped: () -> Void
    var onAddTapped: () -> Void
    
    var body: some View {
        HStack(alignment: .center) {
            if(isSearching) {
                TextField("Search", text: $text)
                    .padding(.horizontal, 12)
                    .padding(.vertical, 14)
                    .overlay(RoundedRectangle(cornerRadius: 8).inset(by: 5).stroke(.blue, lineWidth: 1))
                    
            }
            if(isSearching){
                Button(action: {onCloseTapped()}) {
                    Image(systemName: "xmark")
                        .foregroundColor(Color.black)
                }
            } else {
                Button(action: {onSearchTapped()}) {
                    Image(systemName: "magnifyingglass")
                        .foregroundColor(Color.black)
                }
            }
            Button(action: { onAddTapped() }) {
                Text("+").foregroundColor(.black).font(.title)
            }
        }
        .padding(.horizontal, 8)
    }
}

struct SearchBar_Previews: PreviewProvider {
    static var previews: some View {
        SearchBar(text: .constant("title"), isSearching: true, onSearchTapped: {}, onCloseTapped: {}, onAddTapped: {})
    }
}
