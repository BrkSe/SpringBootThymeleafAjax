package springboot.thymeleafajax.demo.service;

import org.springframework.stereotype.Service;
import springboot.thymeleafajax.demo.KullaniciForm;
import springboot.thymeleafajax.demo.model.Kullanici;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KullaniciService {

    private List<Kullanici> kullanici;

    public List<Kullanici> veriAl(KullaniciForm kullaniciForm) {

        Kullanici user = new Kullanici(kullaniciForm.getAd(), kullaniciForm.getSoyad());

        return new ArrayList<Kullanici>(Arrays.asList(user));

    }

}
