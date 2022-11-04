package pl.szadowek91.punsGame.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.szadowek91.punsGame.config.Properties;
import pl.szadowek91.punsGame.dto.image.ImageDto;
import pl.szadowek91.punsGame.utils.FileUtils;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Optional;

@Service
public class ImageService {

    @Value("${apiKey}")
    public String apiKey;

    public String getImageURL(String imageName) {
        Optional<ImageDto> imgInfos = getAllImageInfo(imageName);
        String imgUrl = "/images/imagenotfound.jpg";
        try {
            imgUrl = String.valueOf(imgInfos.get().getHits().get(0).getWebformatURL());
            if (imgUrl == null || imgUrl.isEmpty()) {
                imgUrl = "/images/imagenotfound.jpg";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }

    private Optional<ImageDto> getAllImageInfo(String imageName) {
        try {
            String urlWithKey = Properties.PIXABAY_API_MAIN_URL + "?key=" + apiKey + "&q=" + imageName + "&image_type=photo";
            URL url = new URL(urlWithKey);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String s = FileUtils.readInputStream(reader);
            Type type = new TypeToken<ImageDto>() {
            }.getType();
            ImageDto imageDto = new Gson().fromJson(s, type);
            return Optional.of(imageDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
