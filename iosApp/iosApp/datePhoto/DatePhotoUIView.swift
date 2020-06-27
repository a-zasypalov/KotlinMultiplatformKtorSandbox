//
//  ContentView.swift
//  MultiplatformKtor
//
//  Created by Артем on 27.06.2020.
//  Copyright © 2020 Gaoyun. All rights reserved.
//

import SwiftUI
import app
import URLImage

struct DatePhotoUIView: View {
    
    @ObservedObject var controller = DatePhotoViewController()
    
    var body: some View {
        NavigationView {
            VStack {
                Text(controller.currentDate)
                if(controller.currentPhoto != nil) {
                    URLImage(controller.currentPhoto!,
                             placeholder: {_ in Text("Image...")},
                             content: {
                                $0.image
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .clipShape(RoundedRectangle(cornerRadius: 5))
                                    .padding(.all, 40.0)
                                    .shadow(radius: 10.0)
                    })
                } else {
                    Text("Image...")
                }
                Text(controller.currentPhotoAuthor)
            }
        }.onAppear {
            self.controller.initDateView()
            self.controller.getPhotos()
        }
    }
    
}

struct DatePhotoView_Previews: PreviewProvider {
    static var previews: some View {
        DatePhotoUIView()
    }
}
