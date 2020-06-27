//
//  IosdateUtilities.swift
//  iosApp
//
//  Created by Артем on 27.06.2020.
//

import Foundation
import app

class IosDateUtilities {
    
    func initPlatformActual() {
        let currentDateClass = DateIos()
        DateUtilitiesKt.dateUtilities.platformDate.setImplementation(protocol: currentDateClass)
    }
    
    class DateIos: DateProtocol {
        func getIosDate() -> String {
            let formatted = DateFormatter()
            formatted.dateFormat = DateUtilities().dateFormat
            return formatted.string(from: Date())
        }
    }
    
}
