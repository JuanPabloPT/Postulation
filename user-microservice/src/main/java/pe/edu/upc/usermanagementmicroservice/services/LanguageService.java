package pe.edu.upc.usermanagementmicroservice.services;

import pe.edu.upc.usermanagementmicroservice.entity.Language;

import java.util.List;

public interface LanguageService {
    public List<Language> findAllLanguages();
    public Language getLanguage(Long id);
    public Language createLanguage(Language language);
    public Language updateLanguage(Language language);
    public Language deleteLanguage(Long id);
}
