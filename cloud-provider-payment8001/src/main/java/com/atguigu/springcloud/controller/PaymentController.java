package com.atguigu.springcloud.controller;import com.atguigu.springcloud.entities.CommonResult;import com.atguigu.springcloud.entities.Payment;import com.atguigu.springcloud.service.PaymentService;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Value;import org.springframework.web.bind.annotation.*;/** * @Author: 车子昂 * @Date: 2020-4-11 10:36 * @Description:业务层 Slf4j  用来打日志 */@RestController@Slf4jpublic class PaymentController {    @Autowired    private PaymentService paymentService;    @Value("${server.port}")    private String serverPort;    //参数Payment payment   应该加注解@RequestBody    @PostMapping(value = "/payment/create")    public CommonResult create(Payment payment) {        int result = paymentService.create(payment);        log.info("新增结果:" + result);        if (result > 0) {            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort + payment.getSerial(), result);        } else {            return new CommonResult(404, "插入数据失败", result);        }    }    @GetMapping(value = "/payment/get/{id}")    public CommonResult getPaymentById(@PathVariable("id") long id) {        Payment payment = paymentService.getPaymentById(id);        log.info("查询结果:" + payment);        if (payment != null) {            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);        } else {            return new CommonResult(404, "没有对应记录,查询ID:" + id, payment);        }    }}