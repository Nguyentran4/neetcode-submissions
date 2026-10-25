class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        vector<int> res(temperatures.size(), 0);
        stack<int> stack; //temp, ind

        for(int i = 0; i < temperatures.size(); i++){
            while(!stack.empty() && temperatures[i] > temperatures[stack.top()]){
                int prev = stack.top();
                stack.pop();
                res[prev] = i - prev;
            }

            stack.push(i);
        }

        return res;
    }
};
