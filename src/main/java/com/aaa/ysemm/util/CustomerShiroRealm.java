package com.aaa.ysemm.util;
import com.aaa.ysemm.customer.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * className:CustomerShiroRealm
 * discriptoin:
 * author:
 * createTime:2018-11-29 18:37
 */
public class CustomerShiroRealm extends AuthorizingRealm implements Serializable{

	@Autowired
	private LoginService loginService;

	/**
	 * 登录认证
	 * 1、authenticationInfo：获取认证消息，如果数据库中没有，返回null，如果得到正确的用户名和密码
	 * 2、AuthenticationInfo  可用simpleAuthenticationInfo实现类，封装获取到的正确的账号和密码
	 * 返回正确类型的对象
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取username
		String userName = (String)token.getPrincipal();
		Session session = SecurityUtils.getSubject().getSession();
		Map map = new HashMap();
		map.put("telephone",userName);
		map.put("status",1);
		System.out.println("map"+map);
		//通过username查询
		List<Map> user = loginService.getSubmitLoin(map);
		String realmName = getName();
		Map emp =null;
		if(user!=null&&user.size()>0){
			emp = user.get(0);
			System.out.println("emp"+emp.toString());
		}
		if(emp==null) {
			throw  new UnknownAccountException(); //账号不存在异常
		}
		System.out.println("passwordSalt"+emp.get("passwordSalt"));
		ByteSource salt = ByteSource.Util.bytes(emp.get("passwordSalt"));
		/*if (0==user.getEnable()) {
			throw new LockedAccountException(); // 帐号锁定
		}*/
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				emp.get("telephone"),//用户名
				emp.get("password"),//密码
				salt,
				realmName//realm name
		);
		//设置盐
		//authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(emp.get("passwordSalt")));
		//当验证信息都通过后，把用户信息放在session里

		session.setAttribute("emp",emp);

		//session.setAttribute("userSessionId",user.getId());
		return authenticationInfo;
	}

	/**
	 * 授权
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		/*//全局通过SecurityUtils.getSubject().getPrincipal()获取用户信息
		Emp userInfo = (Emp) SecurityUtils.getSubject().getPrincipal();
		//通过用户名查出来角色
		//List<String> strings = userInfoService.selectRole(userInfo.getUserName());
		// 权限信息对象info,用来存放查出的用户的所有的角色（role）
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		*//*for(String role:strings){
			//角色名称
			System.out.println(role);
			info.addStringPermission(role);
		}*//*
		//返回角色名称
		return info;
		*/
		return null;
	}
}
