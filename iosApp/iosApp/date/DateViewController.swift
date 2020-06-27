//
//  DateViewController.swift
//  iosApp
//
//  Created by Артем on 27.06.2020.
//

import Foundation
import app

class DateViewController: ObservableObject, DateView {
    
    @Published var currentDate = "Nope"
    
    func initDateView() {
        let iosDateUtilities = IosDateUtilities()
        iosDateUtilities.initPlatformActual()
    
        let presenter = DatePresenter(view: self)
        presenter.doInit()
    }
    
    func showDate(date: String) {
        currentDate = date
    }
    
}
