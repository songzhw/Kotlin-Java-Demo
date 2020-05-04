package ca.six.kjdemo.proxy.retrofit;

import java.util.Map;

class HttpEngine {
    public static <T> T request(String url, Map<String, Object> params, Class<T> responseClass) {
        StringBuilder fakeResp = new StringBuilder();
        fakeResp.append(url);
        fakeResp.append("[");
        for (String key : params.keySet()) {
            fakeResp.append(key + " = " + params.get(key)+", ");
        }
        fakeResp.delete(fakeResp.length()-2, fakeResp.length());
        fakeResp.append("]");

        // 正常情况下是这样:
        // return (T) Gson.fromJson(fakeResp.toString(), responseClass);

        //现在特殊一下, 不想导入gson库, 我们就强转了
        return (T) new User(fakeResp.toString());
    }
}
