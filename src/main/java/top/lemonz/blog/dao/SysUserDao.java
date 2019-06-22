package top.lemonz.blog.dao;

import org.springframework.stereotype.Service;
import top.lemonz.blog.pojo.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author xlm
 * @since 2019-06-22 23:35:58
 */
@Service
public interface SysUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Select(" SELECT " +
              " user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark " +
            " FROM ry.sys_user " +
            " WHERE user_id = #{userId} "
    )
    SysUser queryById(Long userId);
    
    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return Map对象
     */
    @Select(" SELECT " +
              " user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark " +
            " FROM ry.sys_user " +
            " WHERE user_id = #{userId} "
    )
    Map<String,Object> queryByIdMap(Long userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Select(" SELECT " +
              " user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark " +
            " FROM ry.sys_user " +
            " LIMIT #{offset}, #{limit} "
    )
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @Select("<script> " +
            " SELECT " +
              " user_id, dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark " +
            " FROM ry.sys_user " +
            " WHERE 1=1 " +
              " <if test='userId != null'> " +
                    " AND user_id = #{userId} " +
              " </if> " +
              " <if test='deptId != null'> " +
                    " AND dept_id = #{deptId} " +
              " </if> " +
              " <if test='loginName != null and loginName != \"\"'> " +
                    " AND login_name = #{loginName} " +
              " </if> " +
              " <if test='userName != null and userName != \"\"'> " +
                    " AND user_name = #{userName} " +
              " </if> " +
              " <if test='userType != null and userType != \"\"'> " +
                    " AND user_type = #{userType} " +
              " </if> " +
              " <if test='email != null and email != \"\"'> " +
                    " AND email = #{email} " +
              " </if> " +
              " <if test='phonenumber != null and phonenumber != \"\"'> " +
                    " AND phonenumber = #{phonenumber} " +
              " </if> " +
              " <if test='sex != null and sex != \"\"'> " +
                    " AND sex = #{sex} " +
              " </if> " +
              " <if test='avatar != null and avatar != \"\"'> " +
                    " AND avatar = #{avatar} " +
              " </if> " +
              " <if test='password != null and password != \"\"'> " +
                    " AND password = #{password} " +
              " </if> " +
              " <if test='salt != null and salt != \"\"'> " +
                    " AND salt = #{salt} " +
              " </if> " +
              " <if test='status != null and status != \"\"'> " +
                    " AND status = #{status} " +
              " </if> " +
              " <if test='delFlag != null and delFlag != \"\"'> " +
                    " AND del_flag = #{delFlag} " +
              " </if> " +
              " <if test='loginIp != null and loginIp != \"\"'> " +
                    " AND login_ip = #{loginIp} " +
              " </if> " +
              " <if test='loginDate != null and loginDate != \"\"'> " +
                    " AND login_date = #{loginDate} " +
              " </if> " +
              " <if test='createBy != null and createBy != \"\"'> " +
                    " AND create_by = #{createBy} " +
              " </if> " +
              " <if test='createTime != null and createTime != \"\"'> " +
                    " AND create_time = #{createTime} " +
              " </if> " +
              " <if test='updateBy != null and updateBy != \"\"'> " +
                    " AND update_by = #{updateBy} " +
              " </if> " +
              " <if test='updateTime != null and updateTime != \"\"'> " +
                    " AND update_time = #{updateTime} " +
              " </if> " +
              " <if test='remark != null and remark != \"\"'> " +
                    " AND remark = #{remark} " +
              " </if> " +
            " </script>"
    )
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    @Insert(" INSERT INTO ry.sys_user(dept_id, login_name, user_name, user_type, email, phonenumber, sex, avatar, password, salt, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark) " +
            " VALUES (#{deptId}, #{loginName}, #{userName}, #{userType}, #{email}, #{phonenumber}, #{sex}, #{avatar}, #{password}, #{salt}, #{status}, #{delFlag}, #{loginIp}, #{loginDate}, #{createBy}, #{createTime}, #{updateBy}, #{updateTime}, #{remark}) "
    )
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    @Transactional(rollbackFor=Exception.class)
    Integer insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    @Update("<script> " +
            " UPDATE ry.sys_user " +
            " SET " +
                " <if test='deptId != null'> " +
                    " dept_id = #{deptId}," +
                " </if> " +
                " <if test='loginName != null and loginName != \"\"'> " +
                    " login_name = #{loginName}," +
                " </if> " +
                " <if test='userName != null and userName != \"\"'> " +
                    " user_name = #{userName}," +
                " </if> " +
                " <if test='userType != null and userType != \"\"'> " +
                    " user_type = #{userType}," +
                " </if> " +
                " <if test='email != null and email != \"\"'> " +
                    " email = #{email}," +
                " </if> " +
                " <if test='phonenumber != null and phonenumber != \"\"'> " +
                    " phonenumber = #{phonenumber}," +
                " </if> " +
                " <if test='sex != null and sex != \"\"'> " +
                    " sex = #{sex}," +
                " </if> " +
                " <if test='avatar != null and avatar != \"\"'> " +
                    " avatar = #{avatar}," +
                " </if> " +
                " <if test='password != null and password != \"\"'> " +
                    " password = #{password}," +
                " </if> " +
                " <if test='salt != null and salt != \"\"'> " +
                    " salt = #{salt}," +
                " </if> " +
                " <if test='status != null and status != \"\"'> " +
                    " status = #{status}," +
                " </if> " +
                " <if test='delFlag != null and delFlag != \"\"'> " +
                    " del_flag = #{delFlag}," +
                " </if> " +
                " <if test='loginIp != null and loginIp != \"\"'> " +
                    " login_ip = #{loginIp}," +
                " </if> " +
                " <if test='loginDate != null and loginDate != \"\"'> " +
                    " login_date = #{loginDate}," +
                " </if> " +
                " <if test='createBy != null and createBy != \"\"'> " +
                    " create_by = #{createBy}," +
                " </if> " +
                " <if test='createTime != null and createTime != \"\"'> " +
                    " create_time = #{createTime}," +
                " </if> " +
                " <if test='updateBy != null and updateBy != \"\"'> " +
                    " update_by = #{updateBy}," +
                " </if> " +
                " <if test='updateTime != null and updateTime != \"\"'> " +
                    " update_time = #{updateTime}," +
                " </if> " +
                " <if test='remark != null and remark != \"\"'> " +
                    " remark = #{remark}," +
                " </if> " +
            " WHERE user_id = #{userId}" +
            " </script>"
    )
    @Transactional(rollbackFor=Exception.class)
    Integer update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    @Delete(" DELETE FROM ry.sys_user WHERE user_id = #{userId} "
    )
    @Transactional(rollbackFor=Exception.class)
    Integer deleteById(Long userId);

}