package xyz.ueong.mydelacourt;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtServiceMock implements DelacourtService {
    private final BehaviorDelegate<DelacourtService> delegate;

    public DelacourtServiceMock(BehaviorDelegate<DelacourtService> delegate) {
        this.delegate = delegate;
    }
    @Override
    public Observable<List<DelacourtMenu>> getMenus() {
        return delegate.returningResponse(makeMock()).getMenus();
    }

    public List<DelacourtMenu> makeMock() {
        String jsonStr = "[{\n" +
                "    \"title_kor\": \"전주콩나물해장국\",\n" +
                "    \"title_eng\": \"Bean Sprout Hangover Soup\",\n" +
                "    \"id\": \"c804c8fccf69b098bb3cd574c7a5ad6d\",\n" +
                "    \"kcal\": 734,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 5500,\n" +
                "    \"img_src\": \"/image/c804c8fccf69b098bb3cd574c7a5ad6d.jpg\",\n" +
                "    \"corner\": \"KOREAN 1\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 2500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"치즈불닭&맑은감자국\",\n" +
                "    \"title_eng\": \"Hot and Spicy Chicken with Cheese\",\n" +
                "    \"id\": \"ce58c988bd88b2ed0026b9d1c740ac10c790ad6d\",\n" +
                "    \"kcal\": 727,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 5500,\n" +
                "    \"img_src\": \"/image/ce58c988bd88b2ed0026b9d1c740ac10c790ad6d.jpg\",\n" +
                "    \"corner\": \"KOREAN 2\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"low_cal\": true,\n" +
                "    \"payments\": 2500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"만두버섯전골\",\n" +
                "    \"title_eng\": \"Mushroom and Mandu(Dumpling) Hot Pot\",\n" +
                "    \"id\": \"b9ccb450bc84c12fc804ace8\",\n" +
                "    \"kcal\": 823,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/b9ccb450bc84c12fc804ace8.jpg\",\n" +
                "    \"corner\": \"湯탕맛기픈\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"양지설렁탕\",\n" +
                "    \"title_eng\": \"Thick Ox Bone Soup\",\n" +
                "    \"id\": \"c591c9c0c124b801d0d5\",\n" +
                "    \"kcal\": 823,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/c591c9c0c124b801d0d5.jpg\",\n" +
                "    \"corner\": \"湯탕맛기픈\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"나가사끼라멘\",\n" +
                "    \"title_eng\": \"Nakasaki style Ramen\",\n" +
                "    \"id\": \"b098ac00c0acb07cb77cba58\",\n" +
                "    \"kcal\": 830,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/b098ac00c0acb07cb77cba58.jpg\",\n" +
                "    \"corner\": \"가츠&엔\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"매콤토마토소스돈가스\",\n" +
                "    \"title_eng\": \"Spicy Tomato Sauce Pork Cutlet\",\n" +
                "    \"id\": \"b9e4cf64d1a0b9c8d1a0c18cc2a4b3c8ac00c2a4\",\n" +
                "    \"kcal\": 852,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6500,\n" +
                "    \"img_src\": \"/photo/b9e4cf64d1a0b9c8d1a0c18cc2a4b3c8ac00c2a4-1462849347162.jpg\",\n" +
                "    \"corner\": \"가츠&엔\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 4000,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": []\n" +
                "}, {\n" +
                "    \"title_kor\": \"돈목살데리야끼필라프\",\n" +
                "    \"title_eng\": \"Pork Chuck Pilaf with Teriyaki sauce\",\n" +
                "    \"id\": \"b3c8baa9c0b4b370b9acc57cb07cd544b77cd504\",\n" +
                "    \"kcal\": 830,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 5500,\n" +
                "    \"img_src\": \"/image/b3c8baa9c0b4b370b9acc57cb07cd544b77cd504.jpg\",\n" +
                "    \"corner\": \"WESTERN\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 2500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"견과류깐풍오므라이스\",\n" +
                "    \"title_eng\": \"Omelette Rice with Fried Chicken on Nuts\",\n" +
                "    \"id\": \"acacacfcb958ae50d48dc624bbc0b77cc774c2a4\",\n" +
                "    \"kcal\": 855,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/static/no_image_available.jpg\",\n" +
                "    \"corner\": \"WESTERN\",\n" +
                "    \"floor\": \"b1\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": false,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"전주콩나물해장국\",\n" +
                "    \"title_eng\": \"Bean Sprout Hangover Soup\",\n" +
                "    \"id\": \"c804c8fccf69b098bb3cd574c7a5ad6d\",\n" +
                "    \"kcal\": 734,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 5500,\n" +
                "    \"img_src\": \"/image/c804c8fccf69b098bb3cd574c7a5ad6d.jpg\",\n" +
                "    \"corner\": \"KOREAN 1\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 2500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"치즈불닭&맑은감자국\",\n" +
                "    \"title_eng\": \"Hot and Spicy Chicken with Cheese\",\n" +
                "    \"id\": \"ce58c988bd88b2ed0026b9d1c740ac10c790ad6d\",\n" +
                "    \"kcal\": 727,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 5500,\n" +
                "    \"img_src\": \"/image/ce58c988bd88b2ed0026b9d1c740ac10c790ad6d.jpg\",\n" +
                "    \"corner\": \"KOREAN 2\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"low_cal\": true,\n" +
                "    \"payments\": 2500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"투움바파스타\",\n" +
                "    \"title_eng\": \"Toowoomba Pasta\",\n" +
                "    \"id\": \"d22cc6c0bc14d30cc2a4d0c0\",\n" +
                "    \"kcal\": 844,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/d22cc6c0bc14d30cc2a4d0c0.jpg\",\n" +
                "    \"corner\": \"Napolipoli\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"콤비네이션피자\",\n" +
                "    \"title_eng\": \"Combination pizza \",\n" +
                "    \"id\": \"cf64be44b124c774c158d53cc790\",\n" +
                "    \"kcal\": 900,\n" +
                "    \"soldout\": true,\n" +
                "    \"img_src\": \"/image/cf64be44b124c774c158d53cc790.jpg\",\n" +
                "    \"corner\": \"Napolipoli\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"high_cal\": true,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"그린빈스고비커리&치킨티카\",\n" +
                "    \"title_eng\": \"Gobi Curry with Green Beans\",\n" +
                "    \"id\": \"adf8b9b0be48c2a4ace0be44cee4b9ac0026ce58d0a8d2f0ce74\",\n" +
                "    \"kcal\": 796,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/adf8b9b0be48c2a4ace0be44cee4b9ac0026ce58d0a8d2f0ce74.jpg\",\n" +
                "    \"corner\": \"asian*picks\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"나시고랭\",\n" +
                "    \"title_eng\": \"Nasi goreng \",\n" +
                "    \"id\": \"b098c2dcace0b7ad\",\n" +
                "    \"kcal\": 804,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/b098c2dcace0b7ad.jpg\",\n" +
                "    \"corner\": \"asian*picks\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"해주비빔밥\",\n" +
                "    \"title_eng\": \"Bibimbap with Chicken\",\n" +
                "    \"id\": \"d574c8fcbe44be54bc25\",\n" +
                "    \"kcal\": 795,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/d574c8fcbe44be54bc25.jpg\",\n" +
                "    \"corner\": \"고슬고슬비빈\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"불고기 돌솥비빔밥\",\n" +
                "    \"title_eng\": \"Bulgogi Bibimbap in a Stone Pot\",\n" +
                "    \"id\": \"bd88ace0ae300020b3ccc1a5be44be54bc25\",\n" +
                "    \"kcal\": 790,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6500,\n" +
                "    \"img_src\": \"/image/bd88ace0ae300020b3ccc1a5be44be54bc25.jpg\",\n" +
                "    \"corner\": \"고슬고슬비빈\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 4000,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": [\"/photo/bd88ace0ae300020b3ccc1a5be44be54bc25-1458529325921.jpg\"]\n" +
                "}, {\n" +
                "    \"title_kor\": \"(쉐프)플랫브래드새우샌드위치\",\n" +
                "    \"title_eng\": \"Chef's Choice\",\n" +
                "    \"id\": \"0028c250d5040029d50cb7abbe0cb798b4dcc0c8c6b0c0ccb4dcc704ce58\",\n" +
                "    \"kcal\": 575,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/static/no_image_available.jpg\",\n" +
                "    \"corner\": \"Chef's Counter\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"very_low_cal\": true,\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": false,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"헬시라이트(오징어콩나물덮밥)\",\n" +
                "    \"title_eng\": \"Healthy lite\",\n" +
                "    \"id\": \"d5ecc2dcb77cc774d2b80028c624c9d5c5b4cf69b098bb3cb36ebc250029\",\n" +
                "    \"kcal\": 642,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/static/no_image_available.jpg\",\n" +
                "    \"corner\": \"Chef's Counter\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"very_low_cal\": true,\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": false,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"사천자장면\",\n" +
                "    \"title_eng\": \"Sichuan-style Noodles in Black Soybean Sauce\",\n" +
                "    \"id\": \"c0accc9cc790c7a5ba74\",\n" +
                "    \"kcal\": 848,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/c0accc9cc790c7a5ba74.jpg\",\n" +
                "    \"corner\": \"XingFu China\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"고추잡채덮밥\",\n" +
                "    \"title_eng\": \"Shredded and Sauteed Hot Peppers on the Rice\",\n" +
                "    \"id\": \"ace0cd94c7a1cc44b36ebc25\",\n" +
                "    \"kcal\": 847,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6500,\n" +
                "    \"img_src\": \"/image/ace0cd94c7a1cc44b36ebc25.jpg\",\n" +
                "    \"corner\": \"XingFu China\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 4000,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"함경도두부김치말이국수\",\n" +
                "    \"title_eng\": \"Noodles with Tofu and Kimchi Broth\",\n" +
                "    \"id\": \"d568acbdb3c4b450bd80ae40ce58b9d0c774ad6dc218\",\n" +
                "    \"kcal\": 716,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/static/no_image_available.jpg\",\n" +
                "    \"corner\": \"우리味각면\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"low_cal\": true,\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": false,\n" +
                "    \"img_src_more\": null\n" +
                "}, {\n" +
                "    \"title_kor\": \"열무물냉면\",\n" +
                "    \"title_eng\": \"Cold Noodles in Young Summer Radish Kimchi \",\n" +
                "    \"id\": \"c5f4bb34bb3cb0c9ba74\",\n" +
                "    \"kcal\": 731,\n" +
                "    \"soldout\": false,\n" +
                "    \"price\": 6000,\n" +
                "    \"img_src\": \"/image/c5f4bb34bb3cb0c9ba74.jpg\",\n" +
                "    \"corner\": \"우리味각면\",\n" +
                "    \"floor\": \"b2\",\n" +
                "    \"payments\": 3500,\n" +
                "    \"hasImg\": true,\n" +
                "    \"img_src_more\": null\n" +
                "}]";
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, new TypeToken<List<DelacourtMenu>>(){}.getType());
    }
}
