//
//  ContentView.swift
//  MultiplatformKtor
//
//  Created by Артем on 27.06.2020.
//  Copyright © 2020 Gaoyun. All rights reserved.
//

import SwiftUI
import app

struct DateUIView: View {
    
    @ObservedObject var controller = DateViewController()
    
    var body: some View {
        NavigationView {
            Text(controller.currentDate)
        }.onAppear {
            self.controller.initDateView()
        }
    }
    
}

struct DateView_Previews: PreviewProvider {
    static var previews: some View {
        DateUIView()
    }
}
