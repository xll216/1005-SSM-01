package com.ssm.shiro;

import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private StudentService studentService;

    private String pass;
    private static final String saltSource = "abcdefg";
    private static final String hashAlgorithmName = "MD5";
    public static final int hashIterations = 1024;

    /**
     * 认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1。token中获取登录的username 注意不需要获取password
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

        //2.利用username查询数据库得到用户的信息
        Student student = studentService.selectByName(username);

        //3.设置盐值，（加密的调料，让加密出来的东西更具安全性，一般是通过数据库查询出
        // 来的，简单的就是把密码根据特定的东西而进行动态加密，如果别人不知道你的盐值，就解不出你的
        // 密码）
        ByteSource credentialsSalt = new Md2Hash(saltSource);

        //返回值实例化
        SimpleAuthenticationInfo info =
                new SimpleAuthenticationInfo(
                        student.getUsername(),//用户名
                        student.getPassword(),//密码
                        credentialsSalt,//加盐
                        getClass().getSimpleName()//realm名称
                );

        return info;
    }

    /**
     * 授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //获取登录的用户名
        Object principal = principalCollection.getPrimaryPrincipal();

        //两个if根据判断赋予登录用户权限
        if ("admin".equals(principal)) {
            info.addRole("admin");
        }

        if ("user".equals(principal)) {
            info.addRole("list");
        }

//        info.addRole("user");


        return info;
    }

    //用来测试的算出密码password盐值加密后的结果，下面方法用于新增用户添加到数据库操作的，我这里就直接用main获得，直接数据库添加了，省时间
    public static void main(String[] args) {
        String credentials = "123";
        Object salt = new Md5Hash(saltSource);
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);

//        System.out.println(md5(credentials));
    }

    public static String md5(String pass) {
        Object salt = new Md5Hash(saltSource);
        Object result = new SimpleHash(hashAlgorithmName, pass, salt, hashIterations);
        String password = result.toString();
        return password;
    }

}
