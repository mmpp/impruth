
	/**
	 * バーコード入力の整合性を評価します
	 * @param バーコード
	 * @return 入力値評価(true:正常)
	 */
	function onScanBarcode(barcode){
		if(barcode.length == 0){
			return false;
		}

		if(! sumcheckBarcode(barcode) ){
			return false;
		}

		return true;
	
	}
	/**
	 * 入力のバーコードを評価します
	 * @return 判断フラグ (true:正常入力)
	 */
	function sumcheckBarcode(barcode){

		if(barcode.length == 10){
			return sumcheckBarcode10(barcode);
		}
		if(barcode.length == 13){
			return sumcheckBarcode13(barcode);
		}
		return false;

	}
	/**
	 * ISBN10のバーコードを評価します
	 * @param ISBN10バーコード
	 * @return 判断フラグ (true:正常入力)
	 */
	function sumcheckBarcode10(barcode){
		// 入力のチェックサムを取得します				
		var checkSumValue = barcode.charAt(9);
		// 入力のバーコードからチェックサムを計算します
		var sumCheckValue = processISBN10(barcode);
		// 入力値が一緒であるかの評価します
		return (checkSumValue==sumCheckValue);
	}
	/**
	 * ISBN10のバーコードからチェックサムを抽出します
	 * @param ISBN10バーコード
	 * @return チェックサム
	 */
	function processISBN10(barcode){
		// 合計値を格納します
		var sumValue = 0;
		// 階層表敬合計値を求めます
		for(var i = 0 ; i < 9 ; i ++){
			var value = barcode.charAt(i);
			sumValue += value * (10-i);
		}
		// 累計のチェックサムを求めます
		return createCheckDegit(sumValue);
	}
	/**
	 *  チェックサムデジットを計算します
	 * @param ISBN10バーコードの算術結果
	 * @return チェックサム
	 */
	function createCheckDegit(sumcheckValue){
		var deg = sumcheckValue %11;
		if(deg==0)
			return 0;
		if(deg==1)
			return 'X';
		return 11 - deg;
			
	}
	/**
	 * ISBN13のバーコードを評価します
	 * @param ISBN13バーコード
	 * @return 判断フラグ (true:正常入力)
	 */
	function sumcheckBarcode13(barcode){
		// 入力値のチェックサムを取得します
		var checkSumValue = barcode.charAt(12);
		// 入力値のチェックサムを算出します
		var sumCheckValue = processISBN13(barcode);
		// 評価します
		return (checkSumValue==sumCheckValue);
	}

	/**
	 * ISBN10のバーコードからチェックサムを抽出します
	 * @param ISBN10バーコード
	 * @return チェックサム
	 */
	function processISBN13(barcode){
		var sumValue = 0;
		
		// モジュラス10 ウェイト3
		for(var i = 0 ; i < 12 ; i ++){
			var value = barcode.charAt(i);
			sumValue += value * (i%2==0?1:3);
		}
		return  createCheckDegit13(sumValue);
	}

	/**
	 *  チェックサムデジットを計算します
	 * @param ISBN13バーコードの算術結果
	 * @return チェックサム
	 */
	function createCheckDegit13(sumcheckValue){
		var deg = sumcheckValue %10;

		return 10 -deg;
	}