import UIKit
import app

class ViewController: UIViewController, DateView {
    
//    var presenter: DatePresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let iosDateUtilities = IosDateUtilities()
        iosDateUtilities.initPlatformActual()
        
        let presenter = DatePresenter(view: self)
        presenter.doInit()
    }
    
    func showDate(date: String) {
        label.text = date
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
