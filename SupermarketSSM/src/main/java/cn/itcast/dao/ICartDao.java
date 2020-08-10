package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.itcast.domain.Cart;
import cn.itcast.vo.CartVo;

@Repository
public interface ICartDao {
	
	//根据会员号和商品编号查询购物车的信息
	@Select("select * from Cart where memberId=#{memberId} and productId=#{productId}")
	Cart selectCart(Cart cart);
	
	//根据会员号和商品编号修改购物车商品数量
	@Update("update Cart set productNumber=#{productNumber} where memberId=#{memberId} and productId=#{productId}")
	Integer updateCartPN(Cart cart);
	
	//加入购物车
	@Insert("insert into Cart(memberId,productId,productNumber) values(#{memberId},#{productId},#{productNumber})")
	Integer insertCartTable(Cart cart);
	
	//查询用户的购物车总数
	@Select("SELECT count(*) count FROM cart car,products pro,productcategory pc,productinventory PI WHERE car.ProductId=pro.ProductId AND pro.CategoryId=pc.CategoryId AND pro.ProductId=pi.ProductId AND car.MemberId=#{param1} limit 0,#{param2}")
	Integer selectShippingCartAccount(Integer memberId,Integer pageSize);
	
	//查询用户的购物车
	@Select("SELECT * FROM cart car,products pro,productcategory pc,productinventory PI WHERE car.ProductId=pro.ProductId AND pro.CategoryId=pc.CategoryId AND pro.ProductId=pi.ProductId AND car.MemberId=#{param1} ORDER BY cartId DESC limit #{param2},#{param3}")
	List<CartVo> selectShippingCart(Integer memberId,Integer startIndex,Integer pageSize);
	
	//修改购物车加入商品数量
	@Update("update Cart set productNumber=#{param2} where cartId=#{param1}")
	Integer updateProductNumber(Integer cartId, Integer productNumber);
	
	//删除加入购物车的商品
	@Delete("delete from Cart where cartId=#{cartId}")
	Integer deleteCart(Integer cartId);
	
}
