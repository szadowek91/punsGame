package pl.szadowek91.punsGame.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import pl.szadowek91.punsGame.config.Properties;
import pl.szadowek91.punsGame.dto.word.WordDefinition;
import pl.szadowek91.punsGame.dto.word.WordDictionaryDto;
import pl.szadowek91.punsGame.utils.FileUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author PG
 */

@Service
public class DictService {

    @SneakyThrows
    public List<String> getHints(String word) {
        Optional<WordDictionaryDto> wordDict = getWordDict(word);
        List<String> stringList = new ArrayList<>();
        if (wordDict.isEmpty()) {
            stringList.add("Sorry, there are no hints available for this word.");
            return stringList;
        }
        stringList = wordDict.get().getMeanings()
                .stream()
                .map(m -> m.getDefinitions().stream()
                        .map(WordDefinition::getDefinition)
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .toList();
        return stringList;
    }

    private Optional<WordDictionaryDto> getWordDict(String word) {
        try {
            URL url = new URL(Properties.DICTIONARY_API_URL + word);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String s = FileUtils.readInputStream(reader);
            Type type = new TypeToken<List<WordDictionaryDto>>() {
            }.getType();
            List<WordDictionaryDto> wordDictionaryDtos = new Gson().fromJson(s, type);
            return Optional.of(wordDictionaryDtos.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
