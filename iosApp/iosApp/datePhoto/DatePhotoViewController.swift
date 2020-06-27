//
//  DatePhotoViewController.swift
//  iosApp
//
//  Created by Артем on 27.06.2020.
//

import Foundation
import app

class DatePhotoViewController: ObservableObject, DateView, PhotoView {
    
    @Published var currentDate = "Nope"
    @Published var currentPhoto: URL?
    @Published var currentPhotoAuthor = "Nope"

    
    var datePresenter: DatePresenter!
    var photoPresenter: PhotoPresenter!
    
    func initDateView() {
        let iosDateUtilities = IosDateUtilities()
        iosDateUtilities.initPlatformActual()
    
        datePresenter = DatePresenter(view: self)
        datePresenter.doInit()
    }
    
    func getPhotos() {
        photoPresenter = PhotoPresenter(useCase: PhotoUseCase(repository: PhotoRepository(api: PhotoApi())), view: self)
        photoPresenter.getRandomPhoto()
    }
    
    func showDate(date: String) {
        currentDate = date
    }
    
    func setPhoto(photo: PhotoState) {
        currentPhoto = URL(string: (photo.list[0] as! Photo).download_url)
        currentPhotoAuthor = (photo.list[0] as! Photo).author
    }
    
}
