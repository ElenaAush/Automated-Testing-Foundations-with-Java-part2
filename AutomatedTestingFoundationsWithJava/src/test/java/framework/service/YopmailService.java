package framework.service;

import framework.page.yopmail.YopmailEmailPage;
import framework.page.yopmail.YopmailHomePage;

public class YopmailService {
    public static YopmailEmailPage openGeneratedEmail() {
        return new YopmailHomePage().generateEmail().openEmail();
    }
}
