# API
## 生成图片
图片生成功能主要是分为文生图（txt2img）和图生图（img2img），两个API之间有部分可相同的参数，下面是公用参数列表
- 参数
  |参数名|说明|类型|简易模式提供|高级模式提供|建议|
  |-|-|-|-|-|-|
  |prompt|提示词|String，多个值用英文逗号分隔|是|是||
  |negative_prompt|反向提示词|String，多个值用英文逗号分隔|是|是||
  |styles|暂不明|String数组||||
  |denoising_strength|去噪强度|double||是|生成图片时0.75，使用放大插件时0.2|
  |seed|随机种|long||是||
  |subseed|子种子|long||||
  |subseed_strength|暂不明|||||
  |seed_resize_from_h|暂不明|||||
  |seed_resize_from_w|暂不明|||||
  |sampler_name|采样器名称|String||是||
  |batch_size|批量生成数量|int||||
  |n_iter|暂不明|int||||
  |steps|迭代步数|int||是|建议默认设置为20|
  |cfg_scale|提示词影响权重|double||是|值越大，AI发挥空间越小，建议7-30|
  |width|生成图片宽度|int|是|是||
  |height|生成图片高度|int|是|是||
  |restore_faces|面部修复|bool||是|建议简易模式默认开|
  |tiling|生成无缝贴图|bool||||
  |do_not_save_samples|暂不明|boolean||||
  |do_not_save_grid|暂不明|boolean||||
  |eta|暂不明|int||||
  |s_min_uncond|暂不明|double||||
  |s_churn|暂不明|int||||
  |s_tmax|暂不明|int||||
  |s_tmin|暂不明|int||||
  |s_noise|暂不明|int||||
  |override_settings|暂不明|Object|||推测为生成时暂时覆盖的配置|
  |override_settings_restore_afterwards|暂不明|int|||生成后是否恢复覆盖的配置|
  |script_name|脚本名称|String||||
  |script_args|脚本参数|数组||||
  |sampler_index|采样器序列|String||||
  |save_images|暂不明|boolean||||
  |save_images|暂不明|boolean||||
  |alwayson_scripts|暂不明|Object||||

## 文生图（txt2img）
- path：/sdapi/v1/txt2img
- 参数：（以下参数为文生图API独有）
  |参数名|说明|类型|简易模式提供|高级模式提供|建议|
  |-|-|-|-|-|-|
  |enable_hr|是否使用高清修复|bool||||
  |firstphase_width|暂不明|int|||建议设置为0|
  |firstphase_height|暂不明|int|||建议设置为0|
  |hr_scale|高清放大倍数|int||||
  |hr_upscaler|放大器名称|String||||
  |hr_second_pass_steps|暂不明|int||||
  |hr_resize_x|暂不明|int||||
  |hr_resize_y|暂不明|int||||

## 图生图（img2img）
- path：/sdapi/v1/img2img
- 参数：（以下参数为图生图API独有）
  |参数名|说明|类型|简易模式提供|高级模式提供|建议|
  |-|-|-|-|-|-|
  |init_images|暂不明|String数组||||
  |resize_mode|缩放模式|int||||
  |image_cfg_scale|暂不明|double|||推测为图片引导权重|
  |mask|暂不明|String||||
  |mask_blur|暂不明|int||||
  |inpainting_fill|暂不明|int||||
  |inpaint_full_res|暂不明|bool||||
  |inpaint_full_res_padding|暂不明|int||||
  |inpainting_mask_invert|暂不明|int||||
  |initial_noise_multiplier|暂不明|int||||
  |include_init_images|暂不明|bool||||

