package springboot.thymeleafajax.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.thymeleafajax.demo.AjaxResponseBody;
import springboot.thymeleafajax.demo.KullaniciForm;
import springboot.thymeleafajax.demo.model.Kullanici;
import springboot.thymeleafajax.demo.service.KullaniciService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeRestController {

	private KullaniciService kullaniciService;

	@Autowired
	public void setKullaniciService(KullaniciService kullaniciService) {
		this.kullaniciService = kullaniciService;
	}

	@PostMapping("/kullanici")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody KullaniciForm kullaniciForm, Errors hata) {

        AjaxResponseBody result = new AjaxResponseBody();

        List<Kullanici> kullaniciList = kullaniciService.veriAl(kullaniciForm);
        if (kullaniciList.isEmpty()) {
            result.setMesaj("sorun olustu");
        } else {
            result.setMesaj("basarili");
        }

        result.setSonuc(kullaniciList);
        return ResponseEntity.ok(result);

    }
}
