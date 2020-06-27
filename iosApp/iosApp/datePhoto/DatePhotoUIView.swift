//
//  ContentView.swift
//  MultiplatformKtor
//
//  Created by Артем on 27.06.2020.
//  Copyright © 2020 Gaoyun. All rights reserved.
//

import SwiftUI
import app

struct DatePhotoUIView: View {
    
    @ObservedObject var controller = DatePhotoViewController()
    
    var body: some View {
        NavigationView {
            VStack {
                Text(controller.currentDate)
                Spacer()
                Text(controller.currentPhoto)
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
